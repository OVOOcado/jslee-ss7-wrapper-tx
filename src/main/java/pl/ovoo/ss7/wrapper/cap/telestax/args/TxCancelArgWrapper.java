/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import pl.ovoo.ss7.wrapper.cap.args.CancelArgWrapper;

/**
 * OcCancelArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCancelArgWrapper implements CancelArgWrapper {

	private boolean isAllRequests;

	@Override
	public void setAllRequests() {
		isAllRequests = true;
	}

	public boolean isTxAllRequests() {
		return isAllRequests;
	}

	@Override
	public String toString() {
		return "TxCancelArgWrapper [isAllRequests=" + isAllRequests + "]";
	}

}
