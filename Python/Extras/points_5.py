"""
20 to 24 = 3 points
25 to 29 = 4 points
30 to 34 = 5 points
35 to 49 = 6 points
"""
import math


def _get_point(num):
    return int(num / 5) - 1


class Logic:
    def points(self):
        first_step = int(input("Enter your first_step: "))
        range = int(input("Enter your range: "))
        last_step = int(input("Enter your last_step: "))
        points = int(input("Enter your points: "))
        condition = math.floor((last_step - first_step)/range)
        while condition != 0:
            if first_step+range <= last_step: # 2+2 <= 6
                print("%s to %s = %s points"%(first_step,first_step+(range-1),points)) # 2,4
                points = points + 1
                first_step = first_step + range
                last_step = last_step + range
                condition = condition-1
            else:
                print("The range must be equal to or greater than difference btw first and last number")

if __name__ == "__main__":
    Logic().points()
    # for i in range(1, 50):
    #     print(i, _get_point(i))
