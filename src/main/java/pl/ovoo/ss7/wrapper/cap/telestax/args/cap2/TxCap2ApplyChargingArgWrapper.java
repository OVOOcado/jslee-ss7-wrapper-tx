/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2ApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxApplyChargingArgWrapper;

/**
 * OcApplyChargingArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2ApplyChargingArgWrapper extends TxApplyChargingArgWrapper implements Cap2ApplyChargingArgWrapper {
    
    private transient Cap2AChBillingChargingCharacteristicsWrapper chargingCharacteristicsWrapper = null;

    @Override
    public Cap2AChBillingChargingCharacteristicsWrapper getAChBillingChargingCharacteristics() {
        if (this.chargingCharacteristicsWrapper == null && getTxAchBillingChargingCharacteristics() != null) {
            this.chargingCharacteristicsWrapper = new TxCap2AChBillingChargingCharacteristicsWrapper(getTxAchBillingChargingCharacteristics());
        }
        return this.chargingCharacteristicsWrapper;
    }

}
