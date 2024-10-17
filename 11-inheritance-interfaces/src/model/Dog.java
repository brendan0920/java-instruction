package model;

public class Dog extends Animal {
	private boolean docked;
	private boolean pottytrained;
		
	public Dog(String name, int birthYear, char gender, boolean docked, boolean pottytrained) {
		super(name, birthYear, gender);
		this.docked = docked;
		this.pottytrained = pottytrained;
	}

		public boolean isDocked() {
		return docked;
	}

	public void setDocked(boolean docked) {
		this.docked = docked;
	}

	public boolean isPottytrained() {
		return pottytrained;
	}

	public void setPottytrained(boolean pottytrained) {
		this.pottytrained = pottytrained;
	}
	
	@Override
	public String speak() {		
		return "Woof!";
	}

	@Override
	public String toString() {
		return "Dog [docked=" + docked + ", pottytrained=" + pottytrained + ", speak()=" + speak() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public String whatICanDo() {
		return "speak on command, play game";
	}
	
}
