/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberState;

import pl.ovoo.jslee.ss7.wrapper.map.args.SubscriberStateWrapper;


/**
 * OcSubscriberStateWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxSubscriberStateWrapper implements SubscriberStateWrapper {

	/** The tx subscriber state. */
	private final SubscriberState txSubscriberState;

	/**
	 * Instantiates a new tx subscriber state wrapper.
	 *
	 * @param subscriberState the subscriber state
	 */
	public TxSubscriberStateWrapper(final SubscriberState subscriberState) {
		this.txSubscriberState = subscriberState;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.SubscriberStateWrapper#getNotReachableReason()
	 */
	@Override
	public NotReachableReason getNotReachableReason() {
		if (txSubscriberState.getNotReachableReason() != null) {
			return NotReachableReason.valueOf(txSubscriberState.getNotReachableReason().getCode());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.SubscriberStateWrapper#hasNotReachableReason()
	 */
	@Override
	public boolean hasNotReachableReason() {
		return txSubscriberState.getNotReachableReason() != null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.SubscriberStateWrapper#getSubscriberStateChoice()
	 */
	@Override
	public SubscriberStateChoice getSubscriberStateChoice() {
		if (txSubscriberState.getSubscriberStateChoice() != null) {
			return SubscriberStateChoice.valueOf(txSubscriberState.getSubscriberStateChoice().name());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.SubscriberStateWrapper#hasSubscriberStateChoice()
	 */
	@Override
	public boolean hasSubscriberStateChoice() {
		return txSubscriberState.getSubscriberStateChoice() != null;
	}

	/**
	 * Gets the tx subscriber state.
	 *
	 * @return the tx subscriber state
	 */
	public SubscriberState getTxSubscriberState() {
		return txSubscriberState;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxSubscriberStateWrapper [txSubscriberState=" + txSubscriberState + "]";
	}

}
