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

import org.mobicents.protocols.ss7.cap.api.primitives.BCSMEvent;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2BCSMEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2DPSpecificCriteriaWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxBCSMEventWrapper;


/**
 * OcCap2BCSTxCap2BCSMEventWrapperMEventWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2BCSMEventWrapper extends TxBCSMEventWrapper implements Cap2BCSMEventWrapper {

    /**
     * Instantiates a new tx cap2 bcsm event wrapper.
     *
     * @param bcsmEvent the bcsm event
     */
    public TxCap2BCSMEventWrapper(final BCSMEvent bcsmEvent) {
        super(bcsmEvent);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2BCSMEventWrapper#hasDPSpecificCriteria()
     */
    @Override
    public boolean hasDPSpecificCriteria() {
        return bcsmEvent.getDpSpecificCriteria()!= null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2BCSMEventWrapper#getDPSpecificCriteria()
     */
    @Override
    public Cap2DPSpecificCriteriaWrapper getDPSpecificCriteria() {
        if (bcsmEvent.getDpSpecificCriteria()!= null) {
            return new TxCap2DPSpecificCriteriaWrapper(bcsmEvent.getDpSpecificCriteria());
        }
        return null;
    }
}
