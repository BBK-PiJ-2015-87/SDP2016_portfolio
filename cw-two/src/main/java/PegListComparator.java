import interfaces.Colour;
import interfaces.Peg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Created by Rustam Drake and Vladimirs Ivanovs on 05/03/16.
 */
public class PegListComparator {

    /**
     * Returns list of BLACK and WHITE pegs if matches found.
     *
     * @param coded list of pegs
     * @param guess list of pegs
     * @return list of black and white pegs
     */
    public List<Peg> findResult(List<Peg> coded, List<Peg> guess) {
        List<Peg> blacks = findMatchedByColourAndPos(coded, guess);
        List<Peg> whites = findMatchedOnlyByColour(coded, guess);

        return Stream.of(blacks, whites).flatMap(x -> x.stream()).collect(Collectors.toList());
    }

    /**
     * Returns a list of BLACK pegs for pegs with matched colour and position.
     *
     * @param coded list of pegs
     * @param guess list of pegs
     * @return filtered list
     */
    public static List<Peg> findMatchedByColourAndPos(List<Peg> coded, List<Peg> guess) {
        return IntStream.range(0, coded.size())
                .boxed()
                .filter(i -> coded.get(i).equals(guess.get(i)))
                .map(pos -> Colour.BLACK)
                .map(PegImpl::new)
                .collect(Collectors.toList());
    }

    /**
     * Returns list of WHITE pegs for matched colour only.
     * @param coded list of pegs
     * @param guess list of pegs
     * @return list of white pegs
     */
    public static List<Peg>  findMatchedOnlyByColour(List<Peg> coded, List<Peg> guess) {
        Map<Peg, Long> colorMatched = findLowestValueColourPairs(frequency(findUnmatchedPosition(coded, guess)), frequency(findUnmatchedPosition(coded, guess)));

        int numberOfColorMatched = colorMatched.values().stream().mapToInt(Number::intValue).sum();

        List<Peg> whites = IntStream.range(0, numberOfColorMatched)
                .boxed()
                .map(pos -> Colour.WHITE)
                .map(PegImpl::new)
                .collect(Collectors.toList());

        return whites;
    }

    /**
     * Returns a list of pegs, when their position and colour doesn't match to peg from other list.
     *
     * @param toBrFiltered list to be filtered
     * @param compareWith list to compare with
     * @return filtered list
     */
    public static List<Peg> findUnmatchedPosition(List<Peg> toBrFiltered, List<Peg> compareWith) {
        return IntStream.range(0, toBrFiltered.size())
                .boxed()
                .filter(i -> !toBrFiltered.get(i).equals(compareWith.get(i)))
                .map(pos -> toBrFiltered.get(pos))
                .collect(Collectors.toList());
    }

    /**
     * Compares two maps and leaves pairs with lowest values (when colours of these pairs match).
     *
     * @param map1 to be compared
     * @param map2 to be compare with
     * @return map of pairs with lowest values
     */
    public static Map<Peg, Long> findLowestValueColourPairs(Map<Peg, Long> map1, Map<Peg, Long> map2) {
        Map<Peg, Long> result = new HashMap<>();
        map1.entrySet().stream()
                .flatMap(entry -> map2.entrySet().stream()
                        .filter(isSame(entry))
                        .map(filterSmallest(entry)))
                .forEach(e -> result.put(e.getKey(), e.getValue()));

        return result;
    }

    /**
     * Generates map of colours with number of occurrences in the given list.
     *
     * @param list input
     * @return frequency map
     */
    public static Map<Peg, Long> frequency(List<Peg> list) {
        return list.stream()
                .collect(Collectors.groupingBy(peg -> peg, Collectors.counting()));
    }

    /**
     * Predicate to compare colours of pegs in map entry.
     *
     * @param otherEntry to check with
     * @return true if colours of pegs match, false otherwise
     */
    public static Predicate<Map.Entry<Peg,Long>> isSame(Map.Entry<Peg,Long> otherEntry) {
        return entry -> entry.getKey().equals(otherEntry.getKey());
    }

    /**
     * Chooses a pair with lowest value (number of occurrences) from two pairs if .
     *
     * @param otherEntry to check with
     * @return entry with lowest value
     */
    public static Function<Map.Entry<Peg,Long>, Map.Entry<Peg,Long>> filterSmallest(Map.Entry<Peg,Long> otherEntry){
        return entry -> (entry.getValue() <= otherEntry.getValue()) ? entry : otherEntry;
    }
}
