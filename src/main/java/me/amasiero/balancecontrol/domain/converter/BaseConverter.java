package me.amasiero.balancecontrol.domain.converter;

public interface BaseConverter<F, T> {
    T apply(F f);
}
