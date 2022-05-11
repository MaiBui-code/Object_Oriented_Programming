import random
class Reel(object):
    def  spin(self) -> str:
        a = random.randint (0,9)
        if a == 0:
            return "$"
        else: 
            return str(a)
    