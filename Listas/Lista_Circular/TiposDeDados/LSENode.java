package br.unicap.TiposDeDados;
class LSENode <T extends Comparable<T>>{
	private T info;
	private LSENode<T> prox;
	
	LSENode(T obj){
		this.info = obj;
	}
	
	void setInfo(T obj){
		this.info = obj;
	}
	
	T getInfo(){
		return this.info;
	}
	
	void setProx(LSENode<T> prox){
		this.prox = prox;
	}
	
	LSENode<T> getProx(){
		return this.prox;
	}
}