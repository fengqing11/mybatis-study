package top.tamlong.po;

import java.util.List;

//订单持久化类
public class Orders {
	private Integer id;
	private String number;
	private List<Produce> produceList;

	public List<Produce> getProduceList() {
		return produceList;
	}

	public void setProduceList(List<Produce> produceList) {
		this.produceList = produceList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ",number=" + number + ",produceList="+produceList+"]";
	}

}
