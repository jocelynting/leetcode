class ParkingSystem:
    def __init__(self, big: int, medium: int, small: int):
        self.parking = {1: big, 2: medium, 3: small}

    def addCar(self, carType: int) -> bool:
        if self.parking.get(carType, 0) > 0:
            self.parking[carType] -= 1
            return True
        return False


if __name__ == "__main__":
    solution = ParkingSystem(1, 1, 0)

    print("Expected Output : True")
    print("Actual Output : ", solution.addCar(1))
    print("Expected Output : True")
    print("Actual Output : ", solution.addCar(2))
    print("Expected Output : False")
    print("Actual Output : ", solution.addCar(3))
    print("Expected Output : False")
    print("Actual Output : ", solution.addCar(1))
