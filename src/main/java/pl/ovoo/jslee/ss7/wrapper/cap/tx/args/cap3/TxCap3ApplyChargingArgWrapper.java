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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3;

import pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap3.Cap3ApplyChargingArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2ApplyChargingArgWrapper;


/**
 * TxCap3ApplyChargingArgWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap3ApplyChargingArgWrapper extends TxCap2ApplyChargingArgWrapper
        implements Cap3ApplyChargingArgWrapper {

    /** The a ch billing charging characteristics. */
    private transient Cap3AChBillingChargingCharacteristicsWrapper aChBillingChargingCharacteristics = null;

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2ApplyChargingArgWrapper#getAChBillingChargingCharacteristics()
     */
    public Cap3AChBillingChargingCharacteristicsWrapper getAChBillingChargingCharacteristics() {
        if (this.aChBillingChargingCharacteristics == null && getTxAchBillingChargingCharacteristics() != null) {
            this.aChBillingChargingCharacteristics = new TxCap3AChBillingChargingCharacteristicsWrapper(
                    getTxAchBillingChargingCharacteristics());
        }
        return this.aChBillingChargingCharacteristics;
    }

}
