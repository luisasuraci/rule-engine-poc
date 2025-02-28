# Read the JSON file
$json = Get-Content -Raw -Path "complete.json" | ConvertFrom-Json

# Function to generate a new value with a variance of +50 or -50
function Generate-NewValue {
    param (
        [double]$originalValue
    )
    $random = Get-Random -Minimum -50 -Maximum 50
    return $originalValue + $random
}

# Generate new records with randomized values
$newSignals = @()
while ($newSignals.Count -lt 1000) {
    foreach ($signal in $json.signals) {
        $newSignal = $signal.PSObject.Copy()
        $newSignal.value = Generate-NewValue -originalValue $signal.value
        $newSignals += $newSignal
        if ($newSignals.Count -ge 1000) {
            break
        }
    }
}

# Save the new records to a new JSON file
$newJson = [PSCustomObject]@{ signals = $newSignals }
$newJson | ConvertTo-Json -Depth 4 | Set-Content -Path "new_complete.json"

Write-Output "New JSON file with at least 1000 elements and randomized values has been generated and saved as 'new_complete.json'."
