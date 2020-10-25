package simulation;

public class Place {
private int id;
private int jeton;

public Place(int id, int jeton) {
	this.setId(id);
	this.setJeton(jeton);
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getJeton() {
	return jeton;
}

public void setJeton(int jeton) {
	this.jeton = jeton;
}

public void minusJeton() {
	this.jeton--;
}

public void plusJeton() {
	this.jeton++;
}

}
