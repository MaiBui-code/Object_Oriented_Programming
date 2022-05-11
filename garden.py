from tkinter import *
from EnchantedMushroom import EnchantedMushroom
from EnchantedLog import EnchantedLog

def main ():

    # create main tkinter window 
    window: Tk = Tk()

    #set the background color
    window.configure(background= 'navy')

    #set the dimension in pixel
    window.geometry('800x600')

    #create the list for the images: log list and mushroom list 
    # log list
    for i in range (2):
        fileName = f"log{i}.png"
        EnchantedLog.displayImages.append(PhotoImage(file = fileName))
    
    #mushroom list
    for i in range (4):
        fileNameMushroom = f"mushroom{i}.png"
        EnchantedMushroom.displayImages.append(PhotoImage(file = fileNameMushroom))
    """check if not use append but use displayImages[i]"""

    # invoke the function to add the Log and Mushroom to the background window
    for log in EnchantedLog.displayImages:
        addLogWithMushrooms(window, 0,100, 3)
        addLogWithMushrooms (window, 300,350, 4)

    #launch the tkinter window 
    window.mainloop()

# create the addLogWithMushrooms function which adds the them into the background 
def addLogWithMushrooms(window, posX: int, posY: int, numMushrooms: int):
    
    #create a Tkinter Label instance to display the log
    logDisplay: Label = Label(window)

    #created Label instance to place itself on the window at the specified x and y coordinates
    logDisplay.place(x = posX, y = posY)

    #create EnchantedLog instance and pass it the GUI label for displaying
    log: EnchantedLog = EnchantedLog(logDisplay)

    #create mushrooms using createMushroom function
    for i in range (numMushrooms):
        mushroom: EnchantedMushroom = createMushroom(window, posX + 40 + i*100, posY -100)
        log.addMushroom(mushroom)


def createMushroom (window, posX: int, posY: int):

    #create a Tkinter Label instance
    mushroomDisplay: Label = Label (window)

    # place it on the window at the specified location
    mushroomDisplay.place(x = posX, y = posY)

    # create EnchantedMushroom log and pass it the Gui label for displaying
    mushroom: EnchantedMushroom = EnchantedMushroom(mushroomDisplay)

    print(f"Just added a EnchantedMushroom: {mushroom}")
    #return the EnchantedMushroom instance (so the log can add it)
    return mushroom

if __name__ == "__main__":
    main()
    





