SIZE = 140

dico= [ [""]*SIZE for i in range(SIZE)]
with open("D:\\Personnal Projects\\AdventOfCode2023\\day3\\input.txt", 'r', encoding='utf-8') as file:
    for i in range (SIZE) :
        for j in range (SIZE+1) :
            char = file.read(1)
            if j != SIZE :
                dico[i][j] = char

nbTrouve = False
ajout = False
string = ""
somme = 0
for i in range (SIZE) :
    for j in range (SIZE) :
        if dico[i][j].isdigit() :
            nbTrouve = True
            if (i - 1) > 0 and j-1>0 and (dico[i-1][j-1] != '.' and (not dico[i-1][j-1].isdigit())):
                ajout = True
            if (i - 1) > 0 and (dico[i-1][j] != '.' and (not dico[i-1][j].isdigit())):
                ajout = True
            if (i - 1) > 0 and j+1<SIZE and (dico[i-1][j+1] != '.' and (not dico[i-1][j+1].isdigit())):
                ajout = True
            if  j-1>0 and (dico[i][j-1] != '.' and (not dico[i][j-1].isdigit())):
                ajout = True
            if j+1<SIZE and (dico[i][j+1] != '.' and (not dico[i][j+1].isdigit())):
                ajout = True
            if (i + 1) < SIZE and j-1>0 and (dico[i+1][j-1] != '.' and (not dico[i+1][j-1].isdigit())):
                ajout = True
            if (i + 1) < SIZE and j+1<SIZE and (dico[i+1][j+1] != '.' and (not dico[i+1][j+1].isdigit())):
                ajout = True
            if (i + 1) < SIZE and (dico[i+1][j] != '.' and (not dico[i+1][j].isdigit())):
                ajout = True
            

            string += dico[i][j]

        elif (not dico[i][j].isdigit()) and nbTrouve == True :
            if ajout == True :
                somme += int(string)

                ajout = False

            string = ""
            nbTrouve = False
print(somme)
            