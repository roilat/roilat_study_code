package cn.roilat.study.java.libtest;

import java.util.logging.Logger;

public class TestLogger {

	static Logger log = Logger.getAnonymousLogger();
	public static void main(String[] args) {
		log.info("info hello");
		log.warning("warning hello");
		log.fine("fine hello");
	}
}
