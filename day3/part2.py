import re   

def explore (x, y, matrice) :
    string = matrice[y][x]
    if re.match("[0-9]", matrice[y][x]) :
        xtemp = x
        while xtemp+1 < len(matrice[0]) and re.match("[0-9]", matrice[y][xtemp+1]) : 
            
            string = string + matrice[y][xtemp+1]
            xtemp += 1

        xtemp = x
        while xtemp-1 >= 0 and re.match("[0-9]", matrice[y][xtemp-1]) :
            string = matrice[y][xtemp-1] + string 
            xtemp -= 1

        return int(string)
    else :
        return -1

# print(explore(3,0,[["4","6","7",".", ".", "1", "1","4", ".", "." ]]))
f = open("D:\\Personnal Projects\\AdventOfCode2023\\day3\\input.txt", "r")
symbole = [["" for j in range (140)] for i in range (140)]
for y in range (140) :
    for x in range (140) : 
        r = f.read(1)
        if r != '\n' :
            symbole[y][x] = r
        else : 
            symbole[y][x] = f.read(1)

somme = 0
for y in range (140) :
    for x in range (140) :
        if re.match("[^0-9.]", symbole[y][x]) :
            point1x = -1
            point1y = -1
            point1 = -1
            point2x = -1
            point2y = -1
            point2 = -1
            for j in range (-1,2,1) :
                for i in range (-1,2,1) :
                    if (i != 0 or j != 0) and (x+i < 140 and x+i >= 0) and (y+j < 140 and y+j >= 0):
                        if re.match("[0-9]", symbole[y+j][x+i]) :
                            if (point1x == -1) :
                                point1x = x+i
                                point1y = y+j
                                point1 = explore(point1x, point1y, symbole)
                            else :
                                if point1y != y+j or explore(x+i, y+j, symbole) != point1 :
                                    point2x = x+i
                                    point2y = y+j
                                    point2 = explore(point2x, point2y, symbole)
            if (point1 != -1 and point2 != -1)    : 
                somme += point1 * point2

print(somme)