package groupe1c1.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * @author user
 * @date 08/03/2017
 */
public class ListUtils {
	public static <E> ObservableList<E> initObservableList(List<E> initialElems) {
		ObservableList<E> observableList = FXCollections.observableArrayList();
		observableList.addAll(initialElems);
		return observableList;
	}
}
