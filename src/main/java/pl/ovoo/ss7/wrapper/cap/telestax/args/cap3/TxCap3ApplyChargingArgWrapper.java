/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap3;

import pl.ovoo.ss7.wrapper.cap.args.cap3.Cap3AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap3.Cap3ApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2ApplyChargingArgWrapper;

/**
 * TxCap3ApplyChargingArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap3ApplyChargingArgWrapper extends TxCap2ApplyChargingArgWrapper
        implements Cap3ApplyChargingArgWrapper {

    private transient Cap3AChBillingChargingCharacteristicsWrapper aChBillingChargingCharacteristics = null;

    public Cap3AChBillingChargingCharacteristicsWrapper getAChBillingChargingCharacteristics() {
        if (this.aChBillingChargingCharacteristics == null && getTxAchBillingChargingCharacteristics() != null) {
            this.aChBillingChargingCharacteristics = new TxCap3AChBillingChargingCharacteristicsWrapper(
                    getTxAchBillingChargingCharacteristics());
        }
        return this.aChBillingChargingCharacteristics;
    }

}
