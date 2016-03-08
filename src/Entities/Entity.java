package Entities;

public abstract class Entity {
	
	private String entityName;
	
	public Entity(String name) {
		this.entityName = name;
	}
	
	/* GETTERS&SETTERS */
	public void setName(String name)
	{
		this.entityName = name;
	}
	
	public String getName()
	{
		return this.entityName;
	}
	
	@Override
	public String toString()
	{
		return this.entityName;
	}
}
