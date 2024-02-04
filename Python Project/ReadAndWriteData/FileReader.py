import csv

csv_file_path = 'TestData.csv'

# it will give object format
with open(csv_file_path, 'r') as file:
    csv_reader = csv.DictReader(file)
    for row in csv_reader:
        print(row)
print("-----------------------------")
# to read its contents
with open(csv_file_path, 'r') as file:
    csv_reader = csv.reader(file)

    for row in csv_reader:
        print(row)