package zoo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.SelectEvent;

@ManagedBean
public class AutoCompleteView {
	
	List<SelectItem> list;
	
	@PostConstruct
    public void init() {
		List<SelectItem> list = new ArrayList<>();
		for(Integer i = 0; i < 10; i++){
			list.add(new SelectItem(i.toString(), i.toString()));
		}
		this.list = list;
	}
	
	
	public List<SelectItem> getList() {
		return list;
	}

	public void setList(List<SelectItem> list) {
		this.list = list;
	}
}