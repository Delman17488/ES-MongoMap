package uk.ac.bham.mongoMap.map;

public class Packet<T> {
	
	private boolean lastPacket = false;
	private T payload;
	
	public Packet(T payload) {
		this.payload = payload;
	}

	public boolean isLastPacket() {
		return lastPacket;
	}

	public void setLastPacket(boolean lastPacket) {
		this.lastPacket = lastPacket;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
	
}
