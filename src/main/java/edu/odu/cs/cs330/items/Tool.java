package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one tool--as found in most video games. This includes
 * pickaxes and shovels.
 *
 * Tools may not be stacked. All Constructors must initialize Item::stackable
 * to false.
 */
@SuppressWarnings({
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.ShortClassName",
})
public class Tool extends Equippable {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Dur: %d%n",
        "  Spd: %d%n",
        "  Mtl: %s%n",
        "  Mdr: %s (Lvl %d)%n"
    );

    /**
     * Base operation (e.g., harvest/mine) speed.
     */
    protected int speed;

    /**
     * Default to an unstackable tool with zero speed.
     */
    public Tool()
    {
        super();

        this.speed = 0;
    }

    /**
     * Retrieve tool speed.
     *
     * @return how quickly a tool operates
     */
    public int getSpeed()
    {
        return this.speed;
    }

    /**
     * Set tool speed.
     *
     * @param spd new speed
     */
    public void setSpeed(int spd)
    {
        this.speed = spd;
    }

    @Override
    public int requiredNumberOfValues()
    {
        // Replace this with the correct value
        return -1;
    }

    @Override
    public void fromTokens(String[] tokens)
    {

    }

    /**
     * Clone--i.e., copy--this Tool.
     */
    @Override
    public Item clone()
    {
        Tool cpy = new Tool();
        
        cpy.name = this.name;
        cpy.speed = this.speed;
        cpy.setDurability(this.getDurability());
        cpy.setMaterial(this.getMaterial());
        cpy.setModifier(this.getModifier());
        cpy.setModifierLevel(this.getModifierLevel());
    	
    	return cpy;
    }

    /**
     * Check for logical equivalence--based on name, speed, material, modifier,
     * and modifierLevel
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Tool)) {
            return false;
        }

        Tool rhsItem = (Tool) rhs;
        if (this.name.equals(rhsItem.name) 
        		&& this.getMaterial().equals(rhsItem.getMaterial())
        		&& this.getModifier().equals(rhsItem.getModifier())
        		&& this.getModifierLevel()==rhsItem.getModifierLevel()
        		&& this.getElement().equals(rhsItem.getElement())
        		&& this.speed==rhsItem.speed)
        	return true;
        else 
        	return false;
    }

    /**
     * Compute hashCode using name, speed, material, modifier,
     * and modifierLevel.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(
                this.getName(),
                this.getMaterial(),
                this.getModifier(),
                this.getModifierLevel(),
                this.getElement(),
                this.getSpeed()
            );
    }

    /**
     * *Print* a Tool.
     */
    @Override
    public String toString()
    {
        return String.format(
           FMT_STR,
           this.getName(),
           this.getDurability(),
           this.getSpeed(),
           this.getMaterial(),
           this.getModifier(),
           this.getModifierLevel()
        );
    }
}
