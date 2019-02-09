def open_file():
    s = False
    while not s:
        try:
            file_name = input("Enter file name: ").strip()
            file = open(file_name).read().splitlines()
            s = True
        except:
            s = False

    return file

def is_alive(file, y, x):
##    print(x)
##    print(y)
    s = False
    n = 0

    #check top, top right, top left, at least 1 row above point
    if y > 0:
        if file[y-1][x] == 'x':
            n += 1
        if x < len(file[0])-1:
            if file[y-1][x+1] == 'x':
                n += 1
        if x > 0:
            if file[y-1][x-1] == 'x':
                n += 1

    #check right
    if x < len(file[0])-1:
        if file[y][x+1] == 'x':
            n += 1

    #check left
    #print(x)
    if x > 0:
        #print(x)
        if file[y][x-1] == 'x':
            n += 1

    #check bot, bot right, bot left, at least 1 row below point
    if y < len(file)-2:
        if file[y+1][x] == 'x':
            n += 1
        if x < len(file[0])-1:
            if file[y+1][x+1] == 'x':
                n += 1
        if x > 0:
            if file[y+1][x-1] == 'x':
                n += 1

    # return 0 = dead, return 1 = alive, return 2 = stable
##    if y == 7:
##        if x == 23 or x == 24:
##            print(n)
##    print(n, end='')
    
    if n <= 1:
        return 0
    elif n == 2:
        return 2
    elif n == 3:
        return 1
    elif n >= 4:
        return 0

def print_game(file):
    for item in file:
        print(item)

    print("\n\n")

def new_gen(file, length):
    n = []
    for y in range(length-1):
        z = ''
        for x in range(len(file[0])):
##            if y == 7:
##                print(x,s, end=' ')
            s = is_alive(file, y, x)            
            if s == 0:                   
                z += '.'
##                if y == 7:
##                    print(z)
            elif s == 1:
                z += 'x'
##                if y == 7:
##                    print(z)
            elif s == 2:
                z += file[y][x]
##                if y == 7:
##                    print(z)
        n.append(z)
##        print('')

    return n

##window = Tk()
##window.title("Game of Life")
##
##window.mainloop()

file = open_file()
##file_name = 'LIFE_HRV.txt'
##file = open(file_name).read().splitlines()
length = len(file)
x = int(input("Enter number of times you want the game to be played: ").strip())
print_game(file)
for i in range(x):
    file = new_gen(file, length)
    print_game(file)












    
