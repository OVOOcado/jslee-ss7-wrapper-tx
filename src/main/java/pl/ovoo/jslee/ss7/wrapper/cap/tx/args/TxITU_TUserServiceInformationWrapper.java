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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper;


/**
 * TxITU_TUserServiceInformationWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxITU_TUserServiceInformationWrapper implements ITU_TUserServiceInformationWrapper {

	/** The user service information. */
	private final UserServiceInformation userServiceInformation;

	/**
	 * Instantiates a new tx it u_ t user service information wrapper.
	 *
	 * @param userServiceInformation the user service information
	 */
	public TxITU_TUserServiceInformationWrapper(final UserServiceInformation userServiceInformation) {
		this.userServiceInformation = userServiceInformation;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper#hasTransferCapability()
	 */
	@Override
	public boolean hasTransferCapability() {
		return true;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper#getTransferCapability()
	 */
	@Override
	public TransferCapability getTransferCapability() {
		return TransferCapability.valueOf(userServiceInformation.getInformationTransferCapability());

	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper#hasTransferRate()
	 */
	@Override
	public boolean hasTransferRate() {
		return true;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper#getTransferRate()
	 */
	@Override
	public TransferRate getTransferRate() {
		return TransferRate.valueOf(userServiceInformation.getInformationTransferRate());
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper#getTransferMode()
	 */
	@Override
	public TransferMode getTransferMode() {
		return TransferMode.valueOf(userServiceInformation.getTransferMode());
	}

	/**
	 * Gets the tx user service information.
	 *
	 * @return the tx user service information
	 */
	public UserServiceInformation getTxUserServiceInformation() {
		return userServiceInformation;
	}

	/**
	 * The Class TxLayer1CapabilityWrapper.
	 */
	public static class TxLayer1CapabilityWrapper implements Layer1CapabilityWrapper {

		/** The layer1 protocol. */
		private final Layer1Protocol layer1Protocol;

		/**
		 * Instantiates a new tx layer1 capability wrapper.
		 *
		 * @param layer1Protocol the layer1 protocol
		 */
		public TxLayer1CapabilityWrapper(final Layer1Protocol layer1Protocol) {
			this.layer1Protocol = layer1Protocol;
		}

		/* (non-Javadoc)
		 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper.Layer1CapabilityWrapper#getLayer1Protocol()
		 */
		@Override
		public Layer1Protocol getLayer1Protocol() {
			return layer1Protocol;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxITU_TUserServiceInformationWrapper [userServiceInformation=" + userServiceInformation + "]";
	}

}
