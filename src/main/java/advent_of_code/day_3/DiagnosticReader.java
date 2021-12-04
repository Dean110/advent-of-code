package advent_of_code.day_3;

import java.util.List;
import java.util.stream.Collectors;

public class DiagnosticReader {

    public int computePowerConsumption(List<String> diagnostics) {
        int diagnosticLength = diagnostics.get(0).length();
        String gammaRateBinary = convertDiagnosticsToGammaRateBinary(diagnostics, diagnosticLength);
        int gammaRate = Integer.parseInt(gammaRateBinary, 2);

        return (int) (gammaRate * (Math.pow(2,diagnosticLength) - 1 - gammaRate));
    }

    private String convertDiagnosticsToGammaRateBinary(List<String> diagnostics, int diagnosticLength) {
        String gammaRateBinary = "";

        for (int position = 0; position < diagnosticLength; position++) {
            int count = 0;

            for (String diagnostic :diagnostics){
                if(diagnostic.substring(position, position + 1).equals("0")) count++;
            }
            if (count > diagnostics.size() - count) {
                gammaRateBinary += "0";
            } else {
                gammaRateBinary += "1";
            }
        }
        return  gammaRateBinary;
    }

    public int computeLifeSupportRating(List<String> diagnostics) {
        int diagnosticLength = diagnostics.get(0).length();
        int oxygenGeneratorRating = Integer.parseInt(convertDiagnosticsToOxygenGeneratorRatingBinary(diagnostics, diagnosticLength), 2);
        int co2ScrubberRating = Integer.parseInt(convertDiagnosticsToCO2RatingBinary(diagnostics, diagnosticLength),2);

        return oxygenGeneratorRating * co2ScrubberRating;
    }

    private String convertDiagnosticsToOxygenGeneratorRatingBinary(List<String> diagnostics, int diagnosticLength) {
        List<String> candidates = diagnostics;

        for(int i = 0; i < diagnosticLength && candidates.size()>1; i++){
            final int position = i;
            int count = (int) candidates.stream().filter(str -> str.substring(position,position+1).equals("1")).count();
            if(count >= candidates.size() - count){
                candidates = candidates.stream().filter(str -> str.substring(position,position+1).equals("1")).collect(Collectors.toList());
            }else{
                candidates = candidates.stream().filter(str -> str.substring(position,position+1).equals("0")).collect(Collectors.toList());
            }
        }

        return candidates.get(0);
    }

    private String convertDiagnosticsToCO2RatingBinary(List<String> diagnostics, int diagnosticLength) {
        List<String> candidates = diagnostics;

        for(int i = 0; i < diagnosticLength && candidates.size()>1; i++){
            final int position = i;
            int count = (int) candidates.stream().filter(str -> str.substring(position,position+1).equals("0")).count();
            if(count <= candidates.size() - count){
                candidates = candidates.stream().filter(str -> str.substring(position,position+1).equals("0")).collect(Collectors.toList());
            }else{
                candidates = candidates.stream().filter(str -> str.substring(position,position+1).equals("1")).collect(Collectors.toList());
            }
        }

        return candidates.get(0);
    }
}
