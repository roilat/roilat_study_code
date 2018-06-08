package cn.roilat.study.algorithm.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class HashTest {
	private static Random random = new Random();

	public static void main(String[] args) {
		/*
		 * System.out.println("roilat".hashCode());
		 * System.out.println("roilat".hashCode()); System.out.println(new
		 * HashTest().hashCode()); System.out.println(new User().hashCode());
		 * System.out.println(new Integer(123).hashCode());
		 */
		/*
		 * Random r1 = new Random(1L); Random r2 = new Random(1L);
		 * System.out.println(r1.nextInt());//-1155869325
		 * System.out.println(r2.nextInt());//-1155869325
		 * System.out.println(r1.nextInt());//431529176
		 * System.out.println(r2.nextInt());//431529176
		 */

		System.out.println("AYbRQMeUJJEBeQSMDD".hashCode() + "==" + "HIdPjDYYYGSMDCEFFHcjaPCgUGJaCf".hashCode());
		//  findTheSameHashCode();
		// complete-----{-1864901609=AYbRQMeUJJEBeQSMDD,HIdPjDYYYGSMDCEFFHcjaPCgUGJaCf, -1362987613=WUGATeXFViDATQLFfTcJdUMijOZGhbO,QDOPEhGLhhDK, 69539=Eec,dFVhJEfMZSOC, 1265587435=XZcKTPciXaMbhbYCPWJdZ,OCdRYMjZAFHaCEgMeaVEUMSO, 1870352112=gNAjVRhaNPAJ,WNEObbUDEDALeISONVFEBIViBgXH, 71391596=dfRZeVGhHdBAfOFObCCdJHFYKiF,FgWdbMLVeTYXafORTHKUTi, 724859290=cScJicXOCCjXGRbFRfhMOK,iCRiYXKWLiYCceUj, -395824889=RVfRLjFgDhJJRDDYYAi,LZbUNUjUIPZNaMFeXPGZVDMFea, -762839625=XeWTeUgfFd,OEZJibUNagbMhIcffWTM, 2038794645=EBOMic,VjWFWgFDfITTIff, -1878082402=QJFWGGMScEePbQVEePjb,bMGOWBgUbXdWYB, -716837705=NMgeQEDHfehaUIBNXIYJbGFXPA,bdCXALZcXdcaUePNLNNeGjUM, 1485178708=KiEcJEKVZL,IXZFLOiQcghLddQZiAKjb, -306069230=RALRNCRaGQgcOB,ifDjRTFYSEJEEMdgZUHETafBeTXXbjZ, -944997767=TQEWSKCUNAIea,TVSIYGVILbEIPNZdBHecjDMaOIRdR, -380610427=LMGheJEZAXaUYjZQchTKYiXROZe,JNJgaXdFEdPWOEjRCWVjMHTTACBd, 838073892=CUFSIMWZeFfbFWLMeT,ZLEMIJFNdjFSYjNXDZDaAijRX, 587538012=AcFCaYfgJhaGJAMJdFFJGHQIZAGNiJZ,SjfLLTXAfTFQaZOdQ, 1289880667=XjNTLPPWhbCa,KRHicbHdGQBbTdHILIHNWDNCAVHK, 561970178=JgOWHHRZQIGOJJQdB,IFPROTZiCGPDhKKZBaMS, 1129324847=HaJfjbZRDAQ,YTXCdZhbCHMHehLZKeXjhdZhL}

	}

	private static char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

	public static void findTheSameHashCode() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<Integer, String> mapBak = new HashMap<Integer, String>();
		Set<String> set = new HashSet<String>();
		Set<String> longStringSet = new HashSet<String>();
		int repeatCount = 0;// hashcode 重复的数量
		while (true) {
			if (repeatCount > 20) {// 有一个则结束
				System.out.println("complete-----" + mapBak);
				System.out.println("set is " + set);
				System.out.println("longStringSet is " + longStringSet);
				System.out.println(map.size());
				break;
			}
			String s = genRandomStr();
			if (s.length() > 10) {
				longStringSet.add(s);
			}
			int hashCode = s.hashCode();
			if (map.size() > 0 && map.size() % 100000 == 0) {
				System.out.println(map.size());
			}
			if (map.containsKey(hashCode)) {
				set.add(s);// 重复过
				if (set.size() > 0 && set.size() % 100 == 0) {
					System.out.println("==========set size ==" + set.size());
				}
				if (!s.equals(map.get(hashCode)) && s.length() > 10) {
					mapBak.put(hashCode, map.get(hashCode) + "," + s);
					repeatCount++;
				}
			}
			map.put(hashCode, s);
		}
	}

	public static String genRandomStr() {
		int length = random.nextInt(32);
		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < length; i++) {
			temp.append(CHARS[random.nextInt(36)]);
		}
		return temp.toString();
	}
}

class User {
	private String name;
	private String id;
	private String age;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}