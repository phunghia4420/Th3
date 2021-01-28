/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bth1;

import java.util.Objects;


public class Character {
    private Vector2D position;
    private float orientation;
    private Vector2D velocity;
    private float rotation;
    
    public Character(){}

    public Character(Vector2D position, float orientation, Vector2D velocity, float rotation) {
        this.position = position;
        this.orientation = orientation;
        this.velocity = velocity;
        this.rotation = rotation;
    }

    public Vector2D getPosition() {
        return position;
    }

    public float getOrientation() {
        return orientation;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public float getRotation() {
        return rotation;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void setOrientation(float orientation) {
        this.orientation = orientation;
    }

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Character other = (Character) obj;
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (Float.floatToIntBits(this.orientation) != Float.floatToIntBits(other.orientation)) {
            return false;
        }
        if (!Objects.equals(this.velocity, other.velocity)) {
            return false;
        }
        if (Float.floatToIntBits(this.rotation) != Float.floatToIntBits(other.rotation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Character{" + "position=" + position + ", orientation=" + orientation + ", velocity=" + velocity + ", rotation=" + rotation + '}';
    }
    
    public void update(KinematicOutput kinematicOutput, float time){
        this.velocity = kinematicOutput.getVelocity();
        this.rotation = kinematicOutput.getRotation();
        
        this.position.addVector2D(this.velocity.mulConstant(time));
        this.orientation += this.rotation*time;
    }
    
    public void applyNewOrientation(){
        if (this.velocity.length()>0){
            this.orientation = (float)Math.atan2(-this.velocity.getX(),this.rotation);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
       
    }
}
