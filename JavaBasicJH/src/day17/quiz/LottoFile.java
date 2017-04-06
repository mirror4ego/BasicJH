package day17.quiz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LottoFile {
	
	public static ArrayList<Lotto> loadFile() throws Exception {
		ArrayList<Lotto> list = null;
		try (FileInputStream fis = new FileInputStream("data/lotto.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			list = new ArrayList<>();
			list = (ArrayList<Lotto>) ois.readObject();	
			return list;
		} catch (FileNotFoundException fne) {
			list = new ArrayList<>();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void saveFile(ArrayList<Lotto> list) throws Exception {
		try (FileOutputStream fos = new FileOutputStream("data/lotto.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				) {
			oos.writeObject(list);
		} catch (Exception e) {
			throw e;
		}
		
	}
}
