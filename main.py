from Reel import Reel
from SlotMachine import SlotMachine
def main ():
    #1st case: try the random
    FirstRound = Reel()
    FirstNumber = FirstRound.spin()
    SecondRound = Reel()
    SecondNumber = SecondRound.spin()
    ThirdRound = Reel()
    ThirdNumber = ThirdRound.spin()
    Result1 = SlotMachine(FirstNumber,SecondNumber,ThirdNumber)
    Result1.play()
    #2nd case: try the all $
    Result2 = SlotMachine("$","$","$")
    #3rd case: try the all are the same numbers
    Result3 = SlotMachine("2","2","2")
    print(Result3)
if __name__ == "__main__":

   main()