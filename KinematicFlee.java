/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bth1;

import java.util.Objects;


public class KinematicSeek {
    Character character;
    Character target;
    float maxSpeed;

    public KinematicSeek() {
    }

    public KinematicSeek(Character charater, Character target, float maxSpeed) {
        this.character = charater;
        this.target = target;
        this.maxSpeed = maxSpeed;
    }

    public Character getCharater() {
        return character;
    }

    public Character getTarget() {
        return target;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setCharater(Character charater) {
        this.character = charater;
    }

    public void setTarget(Character target) {
        this.target = target;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KinematicSeek other = (KinematicSeek) obj;
        if (Float.floatToIntBits(this.maxSpeed) != Float.floatToIntBits(other.maxSpeed)) {
            return false;
        }
        if (!Objects.equals(this.character, other.character)) {
            return false;
        }
        if (!Objects.equals(this.target, other.target)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KinematicSeek{" + "charater=" + character + ", target=" + target + ", maxSpeed=" + maxSpeed + '}';
    }
    
    public KinematicOutput ganerateKinematicOutput(){
        Vector2D velocity = new Vector2D();
        velocity = character.getPosition().subVector2D(target.getPosition());
        velocity.normalize();
        velocity.mulConstant(maxSpeed);
        return new KinematicOutput(velocity,0);
    }
}
