package ru.artkorchagin.rxtraining.rx;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import ru.artkorchagin.rxtraining.exceptions.NotImplementedException;

/**
 * @author Vladislav Mitryashkin
 * @since 15.02.23
 */
public class RxMaybeTraining {

    /* Тренировочные методы */

    /**
     * Эммит только 1 положительного элемента либо пустая последовательность
     *
     * @param value любое произвольное число
     * @return {@code Maybe} который эммитит значение {@code value} если оно положительное,
     * либо не эммитит ничего, если {@code value} отрицательное
     */
    Maybe<Integer> positiveOrEmpty(Integer value) {
        if (value > 0) return Maybe.just(value);
        else return Maybe.empty();
    }

    /**
     * Эммит только 1 положительного элемента либо пустая последовательность
     *
     * @param valueSingle {@link Single} который эммитит любое произвольное число
     * @return {@code Maybe} который эммитит значение из {@code valueSingle} если оно эммитит
     * положительное число, иначе не эммитит ничего
     */
    Maybe<Integer> positiveOrEmpty(Single<Integer> valueSingle) {
        if (valueSingle.blockingGet() > 0)
            return Maybe.just(valueSingle.blockingGet());
        else return Maybe.empty();
    }

    /**
     * Сумма всех элементов последовательности
     *
     * @param integerObservable {@link Observable} произвольная последовательность чисел
     * @return {@link Maybe} который эммитит сумму всех элементов, либо не эммитит ничего если
     * последовательность пустая
     */
    Maybe<Integer> calculateSumOfValues(Observable<Integer> integerObservable) {
        if (integerObservable.isEmpty().blockingGet()) return Maybe.empty();
        else return Maybe.just(integerObservable.reduce(0, (x, y) -> x + y).blockingGet());
    }

    /**
     * Если {@code integerMaybe} не эммитит элемент, то возвращать {@code defaultValue}
     *
     * @param defaultValue произвольное число
     * @return {@link Single} который эммитит значение из {@code integerMaybe}, либо
     * {@code defaultValue} если последовательность пустая
     */
    Single<Integer> leastOneElement(Maybe<Integer> integerMaybe, int defaultValue) {
        return Single.just(integerMaybe.defaultIfEmpty(defaultValue).blockingGet());
    }

}
