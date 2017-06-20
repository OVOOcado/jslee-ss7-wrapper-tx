/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

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
