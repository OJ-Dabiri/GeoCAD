import math


def co_plot():
    plname = input("Enter plan name: ")
    fil = open("arcGIS.txt", "a")
    pilnum = int(input("Enter number of pillars:"))
    east = float(input("Enter easting: "))
    nort = float(input("Enter northing: "))
    date = input("Enter survey date: ")
    surv = input("Enter surveyor name: ")
    for i in range(0, pilnum):
        print(plname, file=fil, end=",")
        print(surv, file=fil, end=",")
        print(date, file=fil, end=",")
        print("Pillar {}:".format(i))
        pillar = input("Pillar name: ")
        print(pillar, file=fil, end=",")
        dist = float(input("enter distance: "))
        beard = float(input("enter bearing in degrees: "))
        bearm = float(input("enter bearing in minutes: "))
        beardec = beard + (bearm / 60)
        depar = dist * (math.sin(math.radians(beardec)))
        latt = dist * (math.cos(math.radians(beardec)))
        coneast = east + depar
        connort = nort + latt
        print("Easting: {} ".format(coneast))
        print(coneast, file=fil, end=",")
        print("Northing: {}".format(connort))
        print(connort, file=fil)
    fil.close()
    return


runr = 1
while runr != 0:
    co_plot()
    runr = int(input("Enter 0 to stop"))
