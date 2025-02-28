import csv
import json
import random

# Read the CSV file
csv_file = 'FNC FDE_sample segnali per rule engine.csv'
json_data = []

with open(csv_file, mode='r', encoding='latin1') as file:
    csv_reader = csv.DictReader(file, delimiter=';')
    for row in csv_reader:
        # Handle empty MIN and MAX values
        min_value = float(row['MIN']) if row['MIN'] not in ['\\N', ''] else 0
        max_value = float(row['MAX']) if row['MAX'] not in ['\\N', ''] else 100

        # Remove unwanted fields
        row.pop('#', None)
        row.pop('MIN', None)
        row.pop('MAX', None)

        # Generate two JSON elements for each row with random values between min and max
        for _ in range(2):
            new_row = {key: value for key, value in row.items()}
            new_row['value'] = round(random.uniform(min_value, max_value), 2)
            json_data.append(new_row)

# Generate sample output for 1000 rows
sample_output = json_data[:1000]

# Print the sample output
print(json.dumps(sample_output, indent=4))
