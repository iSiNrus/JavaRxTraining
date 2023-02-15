package ru.artkorchagin.rxtraining.rx;

import io.reactivex.Observable;
import ru.artkorchagin.rxtraining.exceptions.NotImplementedException;

/**
 * @author Vladislav Mitryashkin
 * @since 15.02.23
 */
public class RxErrorsTraining {

    /* Тренировочные методы */

    /**
     * В случае ошибки передавать значение по умолчанию
     *
     * @param intObservable {@link Observable} с произвольным количеством рандомных чисел, который
     *                      может передавать ошибку
     * @param defaultValue  значение по умолчанию, передавать в случае, если последовательность
     *                      {@code intObservable} завершилась с ошибкой {@link Throwable}
     * @return {@link Observable} который эммитит значения из {@code intObservable}, либо
     * defaultValue
     */
    Observable<Integer> handleErrorsWithDefaultValue(Observable<Integer> intObservable, final Integer defaultValue) {
        return intObservable.onErrorReturnItem(defaultValue);
    }

    /**
     * В случае ошибки переключаться на другую последовательность
     *
     * @param intObservable      {@link Observable} с произвольным количеством рандомных чисел, который
     *                           может передавать ошибку
     * @param fallbackObservable {@link Observable} последовательность, на которую нужно
     *                           переключиться в случае ошибки
     * @return {@link Observable} который эммитит значения из {@code intObservable}, либо
     * {@code fallbackObservable}
     */
    Observable<Integer> handleErrorsWithFallbackObservable(Observable<Integer> intObservable, Observable<Integer> fallbackObservable) {
        return intObservable.onErrorResumeNext(fallbackObservable);
    }
}
