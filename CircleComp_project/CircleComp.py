import math
class CircleComp:
    def __init__(self, radius):
        self.radius = radius
        self.diameter = self.radius * 2.0
        self.circumference = 2 * math.pi * self.radius
        self.area = math.pi * self.radius * self.diameter

    def print_diameter(self):
        print(f"Diameter: {self.diameter}")

    def print_area(self):
        print(f"Area: {self.area}")

radius_value = float(input("Enter the radius: "))
circle = CircleComp(radius_value)

circle.print_diameter()
circle.print_area()