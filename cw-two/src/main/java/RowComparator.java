import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

;

/**
 * Created by Workstation on 05/03/16.
 */
public class RowComparator {

    public List<Peg> feedback(List<Peg> coded, List<Peg> guess) {
        List<Peg> blacks = findMatchedByColourAndPos(coded, guess).stream()
                .map(peg -> new PegImpl(Colour.BLACK))
                .collect(Collectors.toList());

        Map<Peg, Long> colorMatched = findMatchedOnlyByColour(findUnmatchedCoded(coded, guess), findUnmatchedGuess(coded, guess));

        int numberOfColorMatched = colorMatched.values().stream().mapToInt(Number::intValue).sum();

        List<Peg> whites = IntStream.range(0, numberOfColorMatched)
                .boxed()
                .map(peg -> new PegImpl(Colour.WHITE))
                .collect(Collectors.toList());

        List<Peg> feedback = Stream.of(blacks, whites).flatMap(x -> x.stream()).collect(Collectors.toList());

        return feedback;
    }

    public Map<Peg, Long> findMatchedOnlyByColour(List<Peg> coded, List<Peg> guess) {
        return findColourPairs(frequency(coded), frequency(guess));
    }

    public List<Peg> findMatchedByColourAndPos(List<Peg> coded, List<Peg> guess) {
        return IntStream.range(0, coded.size())
                .boxed()
                .filter(i -> coded.get(i).equals(guess.get(i)))
                .map(pos -> coded.get(pos))
                .collect(Collectors.toList());
    }

    public List<Peg> findUnmatchedCoded(List<Peg> coded, List<Peg> guess) {
        return IntStream.range(0, coded.size())
                .boxed()
                .filter(i -> !coded.get(i).equals(guess.get(i)))
                .map(pos -> coded.get(pos))
                .collect(Collectors.toList());
    }

    public List<Peg> findUnmatchedGuess(List<Peg> coded, List<Peg> guess) {
        return IntStream.range(0, coded.size())
                .boxed()
                .filter(i -> !coded.get(i).equals(guess.get(i)))
                .map(pos -> coded.get(pos))
                .collect(Collectors.toList());
    }

    public Map<Peg, Long> findColourPairs(Map<Peg, Long> map1, Map<Peg, Long> map2) {
        Map<Peg, Long> result = new HashMap<>();
        map1.entrySet().stream()
                .flatMap(entry -> map2.entrySet().stream()
                        .filter(isSame(entry))
                        .map(filterSmallest(entry)))
                .forEach(e -> result.put(e.getKey(), e.getValue()));

        return result;
    }

    public Map<Peg, Long> frequency(List<Peg> list) {
        return list.stream()
                .collect(Collectors.groupingBy(peg -> peg, Collectors.counting()));
    }

    public Predicate<Map.Entry<Peg,Long>> isSame(Map.Entry<Peg,Long> otherEntry) {
        return entry -> entry.getKey().equals(otherEntry.getKey());
    }

    public Function<Map.Entry<Peg,Long>, Map.Entry<Peg,Long>> filterSmallest(Map.Entry<Peg,Long> otherEntry){
        return entry -> (entry.getValue() <= otherEntry.getValue()) ? entry : otherEntry;
    }
}
