/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;
import pl.ovoo.ss7.wrapper.cap.args.AChBillingChargingCharacteristicsWrapper;

/**
 * OcAChBillingChargingCharacteristicsWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxAChBillingChargingCharacteristicsWrapper implements AChBillingChargingCharacteristicsWrapper {

	private final CAMELAChBillingChargingCharacteristics achBillingChargingCharacteristics;

	public TxAChBillingChargingCharacteristicsWrapper(
			final CAMELAChBillingChargingCharacteristics achBillingChargingCharacteristics) {
		this.achBillingChargingCharacteristics = achBillingChargingCharacteristics;
	}

	public CAMELAChBillingChargingCharacteristics getTxAchBillingChargingCharacteristics() {
		return achBillingChargingCharacteristics;
	}

	@Override
	public String toString() {
		return "TxAChBillingChargingCharacteristicsWrapper [achBillingChargingCharacteristics="
				+ achBillingChargingCharacteristics + "]";
	}

}
