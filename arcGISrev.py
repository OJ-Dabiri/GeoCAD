import math


def co_plot():
    dat = open("datafile.txt", "r")
    fil = open("arcGISrev.txt", "w")
    lns = dat.readlines()
    for i in lns:
        lst = i.split(",")
        pilname = lst[3]
        plnam = lst[0]
        survn = lst[1]
        survdt = lst[2]
        east = int(lst[4])
        nor = int(lst[5])
        dist = int(lst[6])
        bdeg = int(lst[7])
        bmin = int(lst[8])
        bdec = bdeg + (bmin / 60)
        depar = dist * (math.sin(math.radians(bdec)))
        lat = dist * (math.cos(math.radians(bdec)))
        ecor = east + depar
        ncor = nor + lat
        print(plnam, file=fil, end=",")
        print(survdt, file=fil, end=",")
        print(survn, file=fil, end=",")
        print(pilname, file=fil, end=",")
        print(ecor, file=fil, end=",")
        print(ncor, file=fil, end="\n")
    fil.close()
    dat.close()
    print("Done!, no errors")
    return


co_plot()
