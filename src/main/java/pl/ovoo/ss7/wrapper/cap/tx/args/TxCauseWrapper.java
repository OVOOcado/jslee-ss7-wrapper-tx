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

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;
import pl.ovoo.ss7.wrapper.cap.args.CauseWrapper;

/**
 * TxCauseWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCauseWrapper implements CauseWrapper {

	private final CauseIndicators cause;

	public TxCauseWrapper(final CauseIndicators cause) {
		this.cause = cause;
	}

	@Override
	public CodingStandard getCodingStandard() {
		if (cause.getCodingStandard() >= 0) {
			return CodingStandard.valueOf(cause.getCodingStandard());
		}
		return null;
	}

	@Override
	public Location getLocation() {
		if (cause.getLocation() >= 0) {
			return Location.valueOf(cause.getLocation());
		}
		return null;
	}

	@Override
	public Recommendation getRecommendation() {
		if (cause.getRecommendation() >= 0) {
			return Recommendation.valueOf(cause.getRecommendation());
		}
		return null;
	}

	@Override
	public CauseValue getCauseValue() {
		if (cause.getCauseValue() >= 0) {
			return CauseValue.valueOf(cause.getCauseValue());
		}
		return null;
	}

	@Override
	public void setCodingStandard(final CodingStandard codingStandard) {
		cause.setCodingStandard(codingStandard.getValue());
	}

	@Override
	public void setLocation(final Location location) {
		cause.setLocation(location.getValue());
	}

	@Override
	public void setRecommendation(final Recommendation recommendation) {
		cause.setRecommendation(recommendation.getValue());
	}

	@Override
	public void setCauseValue(final CauseValue causeValue) {
		cause.setCauseValue(causeValue.getValue());
	}

	@Override
	public boolean hasCauseValue() {
		return cause.getCauseValue() >= 0;
	}

	public CauseIndicators getTxCause() {
		return cause;
	}

	@Override
	public String toString() {
		return "TxCauseWrapper [cause=" + cause + "]";
	}

}
