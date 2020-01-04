package Khamd;

import cfg.object.ICfgNode;

public class Edge {
	private ICfgNode node;
	private ICfgNode nextNode;
	private Edge nextEdge;
	private float weight;
	private int pathNumber;
	
	public Edge(ICfgNode node, ICfgNode nextNode, int pathNumber ) {
		this.node=node;
		this.nextNode=nextNode;
		this.weight=1;
		this.pathNumber=pathNumber;
	}
	public void addWeight(int unit) {
		this.weight+=unit;
	}
	public ICfgNode getNode() {
		return node;
	}
	public void setNode(ICfgNode node) {
		this.node = node;
	}
	public ICfgNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(ICfgNode nextNode) {
		this.nextNode = nextNode;
	}
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getPathNumber() {
		return pathNumber;
	}
	public void setPathNumber(int pathNumber) {
		this.pathNumber = pathNumber;
	}
	
}
