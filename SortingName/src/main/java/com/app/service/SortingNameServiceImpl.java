package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.util.FilesUtil;

@Service
public class SortingNameServiceImpl implements SortingNameService {

	private void sortingName(List<String> dataName) {
		int size = dataName.size();
		for (int i=0; i<size; i++) {
			for (int j=0; j<size-1; j++) {
				String dataName1 = dataName.get(j);
				String dataName2 = dataName.get(j+1);
				
				String tempName1 = getTempName(dataName1);
				String tempName2 = getTempName(dataName2);
				
				if(tempName1.compareTo(tempName2)>0) {
            		dataName.set(j, dataName2);
            		dataName.set(j+1, dataName1);
                }
			}
		}
	}
	
	private static String getTempName(String name) {
		String[] arrName = name.split("\\s");
		
		String tempName = "";
		for (int a=arrName.length-1; a>=0; a--) {
			if (a==arrName.length-1) {
				tempName = tempName + arrName[a];
			} else {
				tempName = tempName + " " + arrName[a];
			}
		}
		return tempName;
	}

	private void overwriteTextFileSorted(List<String> dataName) throws IOException {
		int size = dataName.size();
		String sortedContent = "";
		for(int i=0;i<size;i++) {
          if (i == size-1) {
        	  sortedContent = sortedContent + dataName.get(i);
          } else {
        	  sortedContent = sortedContent + dataName.get(i) + "\n";
          }
          System.out.println(dataName.get(i));
        }
		
		FilesUtil.writeToTextFile("sorted-names-list.txt", sortedContent);
	}

	@Override
	public List<String> sortingName(String filename) throws IOException {
		List<String> dataName = FilesUtil.readTextFileByLines(filename);
		sortingName(dataName);
		overwriteTextFileSorted(dataName);
		return dataName;
	}

}
