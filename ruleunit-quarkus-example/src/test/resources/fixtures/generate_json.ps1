# Read the CSV file
$csvFile = "FNC FDE_sample segnali per rule engine.csv"
$jsonData = @()

# Function to generate random value between min and max
function Get-RandomValue($min, $max) {
    return [math]::Round((Get-Random -Minimum $min -Maximum $max), 2)
}

# Read the CSV file and process each row
Import-Csv -Path $csvFile -Delimiter ';' | ForEach-Object {
    $row = $_

    # Handle empty MIN and MAX values
    $minValue = if ($row.MIN -ne '\N' -and $row.MIN -ne '') { [float]$row.MIN } else { -100 }
    $maxValue = if ($row.MAX -ne '\N' -and $row.MAX -ne '') { [float]$row.MAX } else { 100 }

    # Ensure min_value is less than max_value
    if ($minValue -ge $maxValue) {
        $minValue = -100
        $maxValue = 100
    }

    # Remove unwanted fields
    $row.PSObject.Properties.Remove('#')
    $row.PSObject.Properties.Remove('MIN')
    $row.PSObject.Properties.Remove('MAX')

    # Generate two JSON elements for each row with random values between min and max
    for ($i = 0; $i -lt 2; $i++) {
        $newRow = $row.PSObject.Copy()
        $newRow | Add-Member -MemberType NoteProperty -Name "value" -Value (Get-RandomValue -min $minValue -max $maxValue)
        $jsonData += $newRow
    }
}

# Generate sample output for 1000 rows
$sampleOutput = $jsonData[0..999]

# Convert to JSON and save to file
$sampleOutput | ConvertTo-Json -Depth 4 | Set-Content -Path "sample_output.json"

Write-Output "The sample JSON output has been saved to 'sample_output.json'."
