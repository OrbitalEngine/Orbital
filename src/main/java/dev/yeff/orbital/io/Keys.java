package dev.yeff.orbital.io;

import lombok.Getter;

import static com.raylib.Raylib.*;

public enum Keys {
    Q(KEY_Q),
    W(KEY_W),
    E(KEY_E),
    R(KEY_R),
    T(KEY_T),
    Y(KEY_Y),
    U(KEY_U),
    I(KEY_I),
    O(KEY_O),
    P(KEY_P),
    A(KEY_A),
    S(KEY_S),
    D(KEY_D),
    F(KEY_F),
    G(KEY_G),
    H(KEY_H),
    J(KEY_J),
    K(KEY_K),
    L(KEY_L),
    Z(KEY_Z),
    X(KEY_X),
    C(KEY_C),
    V(KEY_V),
    B(KEY_B),
    N(KEY_N),
    M(KEY_M),
    NUM_0(KEY_ZERO),
    NUM_1(KEY_ONE),
    NUM_2(KEY_TWO),
    NUM_3(KEY_THREE),
    NUM_4(KEY_FOUR),
    NUM_5(KEY_FIVE),
    NUM_6(KEY_SIX),
    NUM_7(KEY_SEVEN),
    NUM_8(KEY_EIGHT),
    NUM_9(KEY_NINE),
    NUMPAD_0(KEY_KP_0),
    NUMPAD_1(KEY_KP_1),
    NUMPAD_2(KEY_KP_2),
    NUMPAD_3(KEY_KP_3),
    NUMPAD_4(KEY_KP_4),
    NUMPAD_5(KEY_KP_5),
    NUMPAD_6(KEY_KP_6),
    NUMPAD_7(KEY_KP_7),
    NUMPAD_8(KEY_KP_8),
    NUMPAD_9(KEY_KP_9),
    ARROW_UP(KEY_UP),
    ARROW_DOWN(KEY_DOWN),
    ARROW_LEFT(KEY_LEFT),
    ARROW_RIGHT(KEY_RIGHT),
    LEFT_ALT(KEY_LEFT_ALT),
    RIGHT_ALT(KEY_RIGHT_ALT),
    LEFT_CTRL(KEY_LEFT_CONTROL),
    RIGHT_CTRL(KEY_RIGHT_CONTROL),
    SUPER(KEY_LEFT_SUPER),
    APOSTROPHE(KEY_APOSTROPHE),
    COMMA(KEY_COMMA),
    MINUS(KEY_MINUS),
    PERIOD(KEY_PERIOD),
    SLASH(KEY_SLASH),
    SEMICOLON(KEY_SEMICOLON),
    EQUAL(KEY_EQUAL),
    TILDE(KEY_GRAVE),
    BACKSLASH(KEY_BACKSLASH),
    LEFT_BRACKET(KEY_LEFT_BRACKET),
    RIGHT_BRACKET(KEY_RIGHT_BRACKET);

    @Getter
    private int keycode;

    private Keys(int keycode) {
        this.keycode = keycode;
    }
}
