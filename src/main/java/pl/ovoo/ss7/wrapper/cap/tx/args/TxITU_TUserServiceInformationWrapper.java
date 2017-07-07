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

package pl.ovoo.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;
import pl.ovoo.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper;

/**
 * TxITU_TUserServiceInformationWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxITU_TUserServiceInformationWrapper implements ITU_TUserServiceInformationWrapper {

	private final UserServiceInformation userServiceInformation;

	public TxITU_TUserServiceInformationWrapper(final UserServiceInformation userServiceInformation) {
		this.userServiceInformation = userServiceInformation;
	}

	@Override
	public boolean hasTransferCapability() {
		return true;
	}

	@Override
	public TransferCapability getTransferCapability() {
		return TransferCapability.valueOf(userServiceInformation.getInformationTransferCapability());

	}

	@Override
	public boolean hasTransferRate() {
		return true;
	}

	@Override
	public TransferRate getTransferRate() {
		return TransferRate.valueOf(userServiceInformation.getInformationTransferRate());
	}

	@Override
	public TransferMode getTransferMode() {
		return TransferMode.valueOf(userServiceInformation.getTransferMode());
	}

	public UserServiceInformation getTxUserServiceInformation() {
		return userServiceInformation;
	}

	public static class TxLayer1CapabilityWrapper implements Layer1CapabilityWrapper {

		private final Layer1Protocol layer1Protocol;

		public TxLayer1CapabilityWrapper(final Layer1Protocol layer1Protocol) {
			this.layer1Protocol = layer1Protocol;
		}

		@Override
		public Layer1Protocol getLayer1Protocol() {
			return layer1Protocol;
		}
	}

	@Override
	public String toString() {
		return "TxITU_TUserServiceInformationWrapper [userServiceInformation=" + userServiceInformation + "]";
	}

}
