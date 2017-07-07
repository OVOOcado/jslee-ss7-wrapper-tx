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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2;

import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2ApplyChargingArgWrapper;

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
