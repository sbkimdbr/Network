package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logs {

	private static final Logger logger = LoggerFactory.getLogger(Logs.class);
	public void bar() {
		logger.info("bar");
	}
}
