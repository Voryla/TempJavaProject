package com.zwk.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Sync extends AbstractQueuedSynchronizer {
	@Override
	protected boolean tryAcquire(int arg) {
		if(compareAndSetState(0,1)){

		}
		return true;
	}
}
