package com.mygdx.game.Battle;

/**
 * Defines what is a move when in a battle
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class Move {
    // Name of the move
    private String name;

    /*
    Type of the move
    0 - Basic
    1 - Crit
    2 - Heal
     */
    private int type;

    // Damage value
    private int damage;

    // Healing value
    private int heal;
    /*
    Define if the heal move will take effect for multiple turns
    false - 1 turn
    true - 3 turns
     */
    private boolean multipleTurns;

    // Crit value in %
    private int crit;

    /**
     * Constructor for basic move
     * @param name
     * @param damage
     */
    public Move(String name, int damage) {
        this.name = name;
        this.damage = damage;
        type = 0;
    }

    /**
     * Constructor for crit move
     * @param name
     * @param damage
     * @param crit
     */
    public Move(String name, int damage, int crit) {
        this.name = name;
        this.damage = damage;
        this.crit = crit;
        type = 1;
    }

    /**
     * Constructor for heal move
     * @param name
     * @param heal
     * @param multipleTurns
     */
    public Move(String name, int heal, boolean multipleTurns) {
        this.name = name;
        this.heal = heal;
        this.multipleTurns = multipleTurns;
    }
}
